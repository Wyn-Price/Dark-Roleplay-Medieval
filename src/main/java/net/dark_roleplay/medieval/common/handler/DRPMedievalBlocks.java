package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.WoodHelper;
import net.dark_roleplay.medieval.common.blocks.building.CleanPlanks;
import net.dark_roleplay.medieval.common.blocks.building.DryClay;
import net.dark_roleplay.medieval.common.blocks.building.MossyLog;
import net.dark_roleplay.medieval.common.blocks.building.ObsidianGlass;
import net.dark_roleplay.medieval.common.blocks.building.PackedIceBricks;
import net.dark_roleplay.medieval.common.blocks.building.Planks1;
import net.dark_roleplay.medieval.common.blocks.building.SnowBricks;
import net.dark_roleplay.medieval.common.blocks.building.StoneBricks;
import net.dark_roleplay.medieval.common.blocks.building.StonePillar;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Anvil;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Cauldron;
import net.dark_roleplay.medieval.common.blocks.craftingstations.ChoppingBlock;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Firepit;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Grindstone;
import net.dark_roleplay.medieval.common.blocks.craftingstations.HangingCauldron;
import net.dark_roleplay.medieval.common.blocks.craftingstations.JuicePress;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Mortar;
import net.dark_roleplay.medieval.common.blocks.craftingstations.PotteryTurntable;
import net.dark_roleplay.medieval.common.blocks.craftingstations.SpinningWheel;
import net.dark_roleplay.medieval.common.blocks.decorative.BedFrame;
import net.dark_roleplay.medieval.common.blocks.decorative.BookOne;
import net.dark_roleplay.medieval.common.blocks.decorative.Chain;
import net.dark_roleplay.medieval.common.blocks.decorative.GoldenShipsBell;
import net.dark_roleplay.medieval.common.blocks.decorative.Hook;
import net.dark_roleplay.medieval.common.blocks.decorative.KeyHanging;
import net.dark_roleplay.medieval.common.blocks.decorative.MugBeer;
import net.dark_roleplay.medieval.common.blocks.decorative.MugEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.PotionEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.Rope;
import net.dark_roleplay.medieval.common.blocks.decorative.RopeAnchor;
import net.dark_roleplay.medieval.common.blocks.decorative.ShipsHelm;
import net.dark_roleplay.medieval.common.blocks.decorative.Target;
import net.dark_roleplay.medieval.common.blocks.decorative.TorchHolderEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.TorchHolderLit;
import net.dark_roleplay.medieval.common.blocks.decorative.TorchHolderUnlit;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelClosed;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelFilled;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.SidewayBarrel;
import net.dark_roleplay.medieval.common.blocks.decorative.buckets.Bucket;
import net.dark_roleplay.medieval.common.blocks.decorative.buckets.BucketDirt;
import net.dark_roleplay.medieval.common.blocks.decorative.candles.BeesWaxCandle;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.BarrelChair;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.LogChair;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.SimpleChair;
import net.dark_roleplay.medieval.common.blocks.decorative.flowerPot.FlowerPot;
import net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges.HangingBridge;
import net.dark_roleplay.medieval.common.blocks.decorative.lecterns.LargeLectern;
import net.dark_roleplay.medieval.common.blocks.decorative.pottery.UnfiredVase;
import net.dark_roleplay.medieval.common.blocks.decorative.ropeFence.RopeFence;
import net.dark_roleplay.medieval.common.blocks.decorative.tables.BarrelTable;
import net.dark_roleplay.medieval.common.blocks.decorative.tables.SimpleTable;
import net.dark_roleplay.medieval.common.blocks.minerals.AdvancedOre;
import net.dark_roleplay.medieval.common.blocks.other.BeeHive;
import net.dark_roleplay.medieval.common.blocks.other.RegeneratingOre;
import net.dark_roleplay.medieval.common.blocks.other.RopeCoil;
import net.dark_roleplay.medieval.common.blocks.other.gunpowder_trail.GunpowderTrail;
import net.dark_roleplay.medieval.common.blocks.plants.Barley;
import net.dark_roleplay.medieval.common.blocks.plants.Hops;
import net.dark_roleplay.medieval.common.blocks.plants.apples.Apple;
import net.dark_roleplay.medieval.common.blocks.plants.mushrooms.Mushroom;
import net.dark_roleplay.medieval.common.blocks.plants.pears.Pear;
import net.dark_roleplay.medieval.common.blocks.plants.sapling.AppleSappling;
import net.dark_roleplay.medieval.common.blocks.rotary.Axle;
import net.dark_roleplay.medieval.common.blocks.storage.Crate;
import net.dark_roleplay.medieval.common.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.common.blocks.storage.SimpleChest;
import net.dark_roleplay.medieval.common.items.blocks.CleanPlankItem;
import net.dark_roleplay.medieval.common.items.seeds.SeedBarley;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class DRPMedievalBlocks {
	
	/** A **/

	public static StoneBricks ANDESITE_BRICKS = new StoneBricks("andesite_bricks");
	public static StonePillar ANDESITE_PILLAR = new StonePillar("andesite_pillar");
	
	public static Anvil ANVIL = new Anvil("anvil");

	public static Apple APPLE_GREEN = new Apple("apple_green", new ItemStack(DRPMedievalItems.APPLE_GREEN, 1)); //TODO FIX APPLES
	public static Apple APPLE_RED = new Apple("apple_red", new ItemStack(Items.APPLE, 1));
	public static Apple APPLE_YELLOW = new Apple("apple_yellow", new ItemStack(DRPMedievalItems.APPLE_YELLOW, 1));
	public static AppleSappling APPLE_SAPPLING = new AppleSappling("apple_sapling");
	public static Axle AXLE = new Axle("axle");
	
	/** B **/

	public static Barley BARLEY = new Barley("barley");
	
	public static BarrelChair BARREL_CHAIR_OAK = new BarrelChair("barrel_chair_oak");
	public static BarrelChair BARREL_CHAIR_BIRCH = new BarrelChair("barrel_chair_birch");
	public static BarrelChair BARREL_CHAIR_SPRUCE = new BarrelChair("barrel_chair_spruce");
	public static BarrelChair BARREL_CHAIR_JUNGLE = new BarrelChair("barrel_chair_jungle");
	public static BarrelChair BARREL_CHAIR_ACACIA = new BarrelChair("barrel_chair_acacia");
	public static BarrelChair BARREL_CHAIR_DARK_OAK = new BarrelChair("barrel_chair_dark_oak");
	
	public static BarrelEmpty BARREL_EMPTY_OAK = new BarrelEmpty("barrel_empty_oak");
	public static BarrelEmpty BARREL_EMPTY_BIRCH = new BarrelEmpty("barrel_empty_birch");
	public static BarrelEmpty BARREL_EMPTY_SPRUCE = new BarrelEmpty("barrel_empty_spruce");
	public static BarrelEmpty BARREL_EMPTY_JUNGLE = new BarrelEmpty("barrel_empty_jungle");
	public static BarrelEmpty BARREL_EMPTY_ACACIA = new BarrelEmpty("barrel_empty_acacia");
	public static BarrelEmpty BARREL_EMPTY_DARK_OAK = new BarrelEmpty("barrel_empty_dark_oak");
	
	public static BarrelFilled BARREL_WATER_OAK = new BarrelFilled("barrel_water_oak");
	public static BarrelFilled BARREL_WATER_BIRCH = new BarrelFilled("barrel_water_birch");
	public static BarrelFilled BARREL_WATER_SPRUCE = new BarrelFilled("barrel_water_spruce");
	public static BarrelFilled BARREL_WATER_JUNGLE = new BarrelFilled("barrel_water_jungle");
	public static BarrelFilled BARREL_WATER_ACACIA = new BarrelFilled("barrel_water_acacia");
	public static BarrelFilled BARREL_WATER_DARK_OAK = new BarrelFilled("barrel_water_dark_oak");
	
	public static BarrelClosed BARREL_CLOSED_OAK = new BarrelClosed("barrel_closed_oak");
	public static BarrelClosed BARREL_CLOSED_BIRCH = new BarrelClosed("barrel_closed_birch");
	public static BarrelClosed BARREL_CLOSED_SPRUCE = new BarrelClosed("barrel_closed_spruce");
	public static BarrelClosed BARREL_CLOSED_JUNGLE = new BarrelClosed("barrel_closed_jungle");
	public static BarrelClosed BARREL_CLOSED_ACACIA = new BarrelClosed("barrel_closed_acacia");
	public static BarrelClosed BARREL_CLOSED_DARK_OAK = new BarrelClosed("barrel_closed_dark_oak");
	
	public static BarrelFilled BARREL_GUNPOWDER_OAK = new BarrelFilled("barrel_gunpowder_oak");
	public static BarrelFilled BARREL_GUNPOWDER_BIRCH = new BarrelFilled("barrel_gunpowder_birch");
	public static BarrelFilled BARREL_GUNPOWDER_SPRUCE = new BarrelFilled("barrel_gunpowder_spruce");
	public static BarrelFilled BARREL_GUNPOWDER_JUNGLE = new BarrelFilled("barrel_gunpowder_jungle");
	public static BarrelFilled BARREL_GUNPOWDER_ACACIA = new BarrelFilled("barrel_gunpowder_acacia");
	public static BarrelFilled BARREL_GUNPOWDER_DARK_OAK = new BarrelFilled("barrel_gunpowder_dark_oak");
	
	public static BarrelTable BARREL_TABLE_OAK = new BarrelTable("barrel_table_oak");
	public static BarrelTable BARREL_TABLE_BIRCH = new BarrelTable("barrel_table_birch");
	public static BarrelTable BARREL_TABLE_JUNGLE = new BarrelTable("barrel_table_jungle");
	public static BarrelTable BARREL_TABLE_SPRUCE = new BarrelTable("barrel_table_spruce");
	public static BarrelTable BARREL_TABLE_DARK_OAK = new BarrelTable("barrel_table_dark_oak");
	public static BarrelTable BARREL_TABLE_ACACIA = new BarrelTable("barrel_table_acacia");

	public static BookOne bookOne = new BookOne("book_one");
	public static BucketDirt BUCKET_DIRT = new BucketDirt("bucket_dirt");
	public static Bucket BUCKET_EMPTY = new Bucket("bucket_empty");
	public static Bucket BUCKET_WATER = new Bucket("bucket_water");

	/** C **/

	public static Cauldron CAULDRON = new Cauldron("cauldron");
	public static Chain CHAIN = new Chain("chain");
	public static ChoppingBlock CHOPPING_BLOCK = new ChoppingBlock("chopping_block");
	public static CleanPlanks CLEAN_PLANKS = new CleanPlanks("clean_planks");
	public static Crate CRATE = new Crate("crate");
	public static AdvancedOre COPPER_ORE = new AdvancedOre("copper_ore");
	
	
	/** D **/
	
	public static StoneBricks DIORITE_BRICKS = new StoneBricks("diorite_bricks");
	public static StonePillar DIORITE_PILLAR = new StonePillar("diorite_pillar");
	public static DungeonChest DUNGEON_CHEST = new DungeonChest("dungeon_chest");
	public static DryClay DRY_CLAY;
	
	/** E **/

	/** F **/

	public static Firepit FIREPIT = new Firepit("firepit_lit");
	public static FlowerPot FLOWER_POT = new FlowerPot("flower_pot");
	
	/** G **/

	public static GunpowderTrail GUNPOWDER_TRAIL = new GunpowderTrail("gunpowder_trail");
	public static GoldenShipsBell GOLDEN_SHIPS_BELL = new GoldenShipsBell("golden_ship_bell");
	
	public static StoneBricks GRANITE_BRICKS = new StoneBricks("granite_bricks");
	public static StonePillar GRANITE_PILLAR = new StonePillar("granite_pillar");
	
	public static Grindstone GRINDSTONE = new Grindstone("grindstone");

	/** H **/

	public static Hops HOPS = new Hops("hops");
	public static HangingBridge HANGING_BRIDGE_BOTTOM = new HangingBridge("hanging_bridge_bottom" ,0F);
	public static HangingBridge HANGING_BRIDGE_TOP = new HangingBridge("hanging_bridge_top" ,0.5F);
	public static HangingCauldron HANGING_CAULDRON = new HangingCauldron("hanging_cauldron");

	/** I **/
	public static Hook IRON_HOOK = new Hook("iron_hook");
	
	/** J **/
	
	public static JuicePress JUICE_PRESS = new JuicePress("juice_press");

	/** K **/

	public static KeyHanging KEY_HANGING = new KeyHanging("key_hanging");

	/** L **/
	public static LargeLectern LARGE_LECTERN_SPRUCE = new LargeLectern("large_lectern_spruce");//TODO PORT TO WOOD HANDLER
	
	public static LogChair LOG_CHAIR_OAK = new LogChair("log_chair_oak");//TODO PORT TO WOOD HANDLER
	public static LogChair LOG_CHAIR_SPRUCE = new LogChair("log_chair_spruce");
	public static LogChair LOG_CHAIR_BIRCH = new LogChair("log_chair_birch");
	public static LogChair LOG_CHAIR_JUNGLE = new LogChair("log_chair_jungle");
	public static LogChair LOG_CHAIR_ACACIA = new LogChair("log_chair_acacia");
	public static LogChair LOG_CHAIR_DARK_OAK = new LogChair("log_chair_dark_oak");

	
	/** M **/

	public static Mortar MORTAR = new Mortar("mortar");
	public static MossyLog MOSSY_LOG_ACACIA = new MossyLog("mossy_log_acacia");//TODO PORT TO WOOD HANDLER
	public static MossyLog MOSSY_LOG_BIRCH = new MossyLog("mossy_log_birch");
	public static MossyLog MOSSY_LOG_DARK_OAK = new MossyLog("mossy_log_dark_oak");
	public static MossyLog MOSSY_LOG_JUNGLE = new MossyLog("mossy_log_jungle");
	public static MossyLog MOSSY_LOG_OAK = new MossyLog("mossy_log_oak");
	public static MossyLog MOSSY_LOG_SPRUCE = new MossyLog("mossy_log_spruce");
	
	
	public static MugBeer MUG_BEER = new MugBeer("mug_beer");
	public static MugEmpty MUG_EMPTY = new MugEmpty("mug_empty");
	public static Mushroom MUSHROOM_BROWN = new Mushroom("mushroom_brown");
	public static Mushroom MUSHROOM_RED = new Mushroom("mushroom_red");

	/** N **/

	/** O **/
	
	public static ObsidianGlass OBSIDIAN_GLASS = new ObsidianGlass("obsidian_glass");

	/** P **/

	public static Planks1 PLANKS_1 = new Planks1("planks1", "planks1");
	public static PackedIceBricks PACKED_ICE_BRICKS = new PackedIceBricks("packed_ice_bricks");
	public static Pear PEAR_GREEN = new Pear("pear_green", new ItemStack(DRPMedievalItems.PEAR_GREEN, 1)); //TODO FIX PEARS
	public static Pear PEAR_YELLOW = new Pear("pear_yellow", new ItemStack(DRPMedievalItems.PEAR_YELLOW, 1));
	public static PotteryTurntable POTTERY_TURNTABLE = new PotteryTurntable("pottery_turntable");
	public static PotionEmpty POTION_EMPTY = new PotionEmpty("potion_empty"); //TODO Fix Potions
	

	/** Q **/

	/** R **/

	public static RegeneratingOre rgO = new RegeneratingOre("regenOre", DRPMedievalCreativeTabs.drpmedievalMiscTab, 0.4F, 5); //TODO REGENERATING ORES
	public static Rope ROPE = new Rope("rope");
	public static RopeCoil ROPE_COIL = new RopeCoil("rope_coil");
	public static RopeAnchor ROPE_ANCHOR = new RopeAnchor("rope_anchor");
	public static RopeFence ROPE_FENCE = new RopeFence("rope_fence");
	
	/** S **/

	public static AdvancedOre SALPETER_ORE = new AdvancedOre("salpeter_ore");
	public static AdvancedOre SULFUR_ORE = new AdvancedOre("sulfur_ore");
	public static AdvancedOre SILVER_ORE = new AdvancedOre("silver_ore");
	
	public static SimpleChair SIMPLE_CHAIR_OAK = new SimpleChair("simple_chair_oak");;
	public static SimpleChair SIMPLE_CHAIR_BIRCH = new SimpleChair("simple_chair_birch");
	public static SimpleChair SIMPLE_CHAIR_SPRUCE = new SimpleChair("simple_chair_spruce");
	public static SimpleChair SIMPLE_CHAIR_JUNGLE = new SimpleChair("simple_chair_jungle");
	public static SimpleChair SIMPLE_CHAIR_ACACIA = new SimpleChair("simple_chair_acacia");
	public static SimpleChair SIMPLE_CHAIR_DARK_OAK = new SimpleChair("simple_chair_dark_oak");
	
	public static SimpleTable SIMPLE_TABLE_OAK = new SimpleTable("simple_table_oak");
	public static SimpleTable SIMPLE_TABLE_BIRCH = new SimpleTable("simple_table_birch");
	public static SimpleTable SIMPLE_TABLE_SPRUCE = new SimpleTable("simple_table_spruce");
	public static SimpleTable SIMPLE_TABLE_JUNGLE = new SimpleTable("simple_table_jungle");
	public static SimpleTable SIMPLE_TABLE_ACACIA = new SimpleTable("simple_table_acacia");
	public static SimpleTable SIMPLE_TABLE_DARK_OAK = new SimpleTable("simple_table_dark_oak");
	
	public static SidewayBarrel SIDEWAY_BARREL_ACACIA = new SidewayBarrel("sideway_barrel_acacia");
	public static SidewayBarrel SIDEWAY_BARREL_BIRCH = new SidewayBarrel("sideway_barrel_birch");
	public static SidewayBarrel SIDEWAY_BARREL_OAK = new SidewayBarrel("sideway_barrel_oak");
	public static SidewayBarrel SIDEWAY_BARREL_JUNGLE = new SidewayBarrel("sideway_barrel_jungle");
	public static SidewayBarrel SIDEWAY_BARREL_SPRUCE = new SidewayBarrel("sideway_barrel_spruce");
	public static SidewayBarrel SIDEWAY_BARREL_DARK_OAK = new SidewayBarrel("sideway_barrel_dark_oak");
	
	
	public static ShipsHelm SHIPS_HELM = new ShipsHelm("ships_helm");
	
	public static SnowBricks SNOW_BRICKS = new SnowBricks("snow_bricks");
	
	public static SpinningWheel SPINNING_WHEEL = new SpinningWheel("spinning_wheel");
	
	/** T **/

	public static AdvancedOre TIN_ORE = new AdvancedOre("tin_ore");
	public static Target TARGET = new Target("target");
	public static TorchHolderEmpty TORCH_HOLDER_EMPTY = new TorchHolderEmpty("torch_holder_empty");
	public static TorchHolderLit TORCH_HOLDER_LIT = new TorchHolderLit("torch_holder_lit");
	public static TorchHolderUnlit TORCH_HOLDER_UNLIT = new TorchHolderUnlit("torch_holder_unlit");

	/** U **/

	/** V **/

	/** W **/

	/** X **/

	/** Y **/

	/** Z **/
	
	public static SimpleChest CHEST_TEST = new SimpleChest("simple_chest");

	public static UnfiredVase UNFIRED_VASE;
	public static BeeHive BEE_HIVE;
	public static BeesWaxCandle BEESWAX_CANDLE;
	
	
	
	
	static List<Block> blocks = new ArrayList<Block>();
	
	private static IForgeRegistry<Block> reg;
	
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> event) {
		reg = event.getRegistry();
		

		WoodHelper.init();

//		public static UnfiredVase UNFIRED_VASE;
//		public static BeeHive BEE_HIVE;
//		public static BeesWaxCandle BEESWAX_CANDLE;
		
		registerBlock(UNFIRED_VASE = new UnfiredVase("unfired_vase"));
		registerBlock(BEE_HIVE = new BeeHive("bee_hive"));
		registerBlock(BEESWAX_CANDLE = new BeesWaxCandle("beeswax_candle"));
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.DRY_CLAY = new DryClay("dry_clay"));
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SNOW_BRICKS);
		//registerBlock(APPLE_SAPPLING);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARLEY, (ItemBlock) new ItemBlock(DRPMedievalBlocks.BARLEY).setRegistryName(DRPMedievalBlocks.BARLEY.getRegistryName() + "_item"));
		
		DRPMedievalBlocks.TIN_ORE.setOre(DRPMedievalItems.ORE_CHUNK_TIN);
		DRPMedievalBlocks.COPPER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_COPPER);
		DRPMedievalBlocks.SILVER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SILVER);
		DRPMedievalBlocks.SULFUR_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SULFUR);
		DRPMedievalBlocks.SALPETER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SALPETER);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.HOPS, null, false);
		//registerBlock(ROPE_COIL);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.JUICE_PRESS);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.OBSIDIAN_GLASS);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.POTTERY_TURNTABLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.AXLE);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CHEST_TEST);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.TIN_ORE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.COPPER_ORE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SILVER_ORE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SULFUR_ORE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SALPETER_ORE);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ANDESITE_PILLAR);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ANDESITE_BRICKS);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.DIORITE_PILLAR);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.DIORITE_BRICKS);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.GRANITE_PILLAR);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.GRANITE_BRICKS);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_OAK, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_BIRCH, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_JUNGLE, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_ACACIA, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_CHAIR_DARK_OAK, false);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_OAK, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_BIRCH, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_SPRUCE, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_JUNGLE, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_ACACIA, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIMPLE_TABLE_DARK_OAK, false);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_WATER_DARK_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CLOSED_DARK_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.GUNPOWDER_TRAIL);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_GUNPOWDER_DARK_OAK);

		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_DARK_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_TABLE_ACACIA);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BARREL_CHAIR_DARK_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CLEAN_PLANKS, new CleanPlankItem(DRPMedievalBlocks.CLEAN_PLANKS));
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.FLOWER_POT);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SIDEWAY_BARREL_DARK_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CHOPPING_BLOCK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.APPLE_RED, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.APPLE_YELLOW, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.APPLE_GREEN, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.PEAR_YELLOW, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.PEAR_GREEN, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MUSHROOM_BROWN);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MUSHROOM_RED);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BUCKET_EMPTY);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BUCKET_DIRT, false);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.BUCKET_WATER);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MUG_EMPTY);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MUG_BEER);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MORTAR);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.GRINDSTONE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ANVIL);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CAULDRON);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.HANGING_CAULDRON);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_ACACIA);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_BIRCH);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_DARK_OAK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_JUNGLE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.MOSSY_LOG_OAK);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM, null);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.HANGING_BRIDGE_TOP, null);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.LARGE_LECTERN_SPRUCE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ROPE_FENCE);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.bookOne);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ROPE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.ROPE_ANCHOR);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CHAIN);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.CRATE);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.DUNGEON_CHEST);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.IRON_HOOK);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.KEY_HANGING);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SHIPS_HELM);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.TARGET);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.TORCH_HOLDER_EMPTY);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.TORCH_HOLDER_UNLIT);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.TORCH_HOLDER_LIT);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.FIREPIT);
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.PACKED_ICE_BRICKS);
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.SPINNING_WHEEL);
		
		DRPMedievalItems.SeedBarley = new SeedBarley();
		
		DRPMedievalBlocks.registerBlock(DRPMedievalBlocks.GOLDEN_SHIPS_BELL);
		
		reg = null;
	}
	
	public static final void registerBlock(Block block) {
		DRPMedievalBlocks.registerBlock(block,(ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName()),true);
	}
	
	public static final void registerBlock(Block block, boolean registerMesh) {
		DRPMedievalBlocks.registerBlock(block,(ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName()), registerMesh);
	}

	public static final void registerBlock(Block block, ItemBlock item) {
		DRPMedievalBlocks.registerBlock(block, item, true);

	}
	
	public static final void registerBlock(Block block, ItemBlock item, boolean registerMesh) {
		reg.register(block);
		if(item != null){
			DRPMedievalItems.addBlockItem(item);
			if(registerMesh) {
				DRPMedievalModels.addItemToRegisterMesh(item);
			}
		}
	}
	
}
