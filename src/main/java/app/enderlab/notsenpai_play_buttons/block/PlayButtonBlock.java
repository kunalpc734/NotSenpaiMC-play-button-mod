import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.ticks.ScheduledTickAccess;
import net.minecraft.world.phys.shapes.VoxelShape;
/**
 * A thin, waterloggable, wall mounted award plaque.
 *
 * <p>The block can only be placed against the side of a solid block: {@code FACING} always points
 * away from the wall, so the front of the plaque faces out into the room. All four horizontal
 * directions are supported. If the supporting wall disappears the plaque breaks and drops itself.</p>
 */
public class PlayButtonBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final MapCodec<PlayButtonBlock> CODEC = simpleCodec(PlayButtonBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    /** Facing north, the plaque hugs the south wall of its own block space. */
    private static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 5.0D);
    private static final VoxelShape SHAPE_EAST = Block.box(0.0D, 0.0D, 0.0D, 5.0D, 16.0D, 16.0D);
    private static final VoxelShape SHAPE_WEST = Block.box(11.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public PlayButtonBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    private static VoxelShape shapeFor(Direction facing) {
        return switch (facing) {
            case SOUTH -> SHAPE_SOUTH;
            case EAST -> SHAPE_EAST;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapeFor(state.getValue(FACING));
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        boolean inWater = level.getFluidState(pos).getType() == Fluids.WATER;

        for (Direction direction : context.getNearestLookingDirections()) {
            if (!direction.getAxis().isHorizontal()) {
                continue;
            }
            BlockState candidate = this.defaultBlockState()
                    .setValue(FACING, direction)
                    .setValue(WATERLOGGED, inWater);
            if (candidate.canSurvive(level, pos)) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(FACING);
        BlockPos supportPos = pos.relative(facing.getOpposite());
        return level.getBlockState(supportPos).isFaceSturdy(level, supportPos, facing);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos,
                                     Direction direction, BlockPos neighborPos, BlockState neighborState,
                                     RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, 5);
        }
        if (direction == state.getValue(FACING).getOpposite() && !state.canSurvive(level, pos)) {
            if (level instanceof ServerLevel serverLevel) {
                serverLevel.destroyBlock(pos, true);
            }
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, level, ticks, pos, direction, neighborPos, neighborState, random);
    }
}
