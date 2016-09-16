package fantasymetals.init;

import fantasymetals.init.Materials;
import cyano.basemetals.material.MetalMaterial;
import cyano.basemetals.registry.CrusherRecipeRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jasmine Iwanek
 *
 */
public class Recipes {

	private static boolean initDone = false;

	/**
	 *
	 */
	public static void init() {
		if(initDone)
			return;

		fantasymetals.init.Materials.init();
		fantasymetals.init.Blocks.init();
		fantasymetals.init.Items.init();

		initMetalRecipes();

		initDone = true;
	}

	@SuppressWarnings("unused")
	private static void initMetalRecipes() {
		final List<MetalMaterial> exceptions = Arrays.asList(Materials.vanilla_iron, Materials.vanilla_gold, Materials.vanilla_diamond, Materials.vanilla_stone, Materials.vanilla_wood, Materials.copper, Materials.silver, Materials.tin, Materials.lead, Materials.nickel, Materials.bronze, Materials.brass, Materials.steel, Materials.invar, Materials.electrum, Materials.coldiron, Materials.mithril, Materials.adamantine, Materials.starsteel, Materials.zinc, Materials.aquarium);

		for(final MetalMaterial metal : Materials.getAllMetals()) {
			if(exceptions.contains(metal))
				continue;
			String baseName = metal.getName() + "_";
			String oreDictName = metal.getCapitalizedName();
			Item axe = fantasymetals.init.Items.getItemByName(baseName + "axe");
			Item blend = fantasymetals.init.Items.getItemByName(baseName + "blend");
			Item boots = fantasymetals.init.Items.getItemByName(baseName + "boots");
			Item chestplate = fantasymetals.init.Items.getItemByName(baseName + "chestplate");
			Item crackhammer = fantasymetals.init.Items.getItemByName(baseName + "crackhammer");
			Item door = fantasymetals.init.Items.getItemByName(baseName + "door_item");
			Item helmet = fantasymetals.init.Items.getItemByName(baseName + "helmet");
			Item hoe = fantasymetals.init.Items.getItemByName(baseName + "hoe");
			Item ingot = fantasymetals.init.Items.getItemByName(baseName + "ingot");
			Item leggings = fantasymetals.init.Items.getItemByName(baseName + "leggings");
			Item nugget = fantasymetals.init.Items.getItemByName(baseName + "nugget");
			Item pickaxe = fantasymetals.init.Items.getItemByName(baseName + "pickaxe");
			Item powder = fantasymetals.init.Items.getItemByName(baseName + "powder");
			Item shovel = fantasymetals.init.Items.getItemByName(baseName + "shovel");
			Item sword = fantasymetals.init.Items.getItemByName(baseName + "sword");
			Item rod = fantasymetals.init.Items.getItemByName(baseName + "rod");
			Item gear = fantasymetals.init.Items.getItemByName(baseName + "gear");
			Block bars = fantasymetals.init.Blocks.getBlockByName(baseName + "bars");
			Block block = fantasymetals.init.Blocks.getBlockByName(baseName + "block");
			Block plate = fantasymetals.init.Blocks.getBlockByName(baseName + "plate");
			Block ore = fantasymetals.init.Blocks.getBlockByName(baseName + "ore");
			Block trapdoor = fantasymetals.init.Blocks.getBlockByName(baseName + "trapdoor");

			Item arrow = fantasymetals.init.Items.getItemByName(baseName + "arrow");
			Item bow = fantasymetals.init.Items.getItemByName(baseName + "bow");
			Item bolt = fantasymetals.init.Items.getItemByName(baseName + "bolt");
			Item crossbow = fantasymetals.init.Items.getItemByName(baseName + "crossbow");
			Item shears = fantasymetals.init.Items.getItemByName(baseName + "shears");
			Item smallblend = fantasymetals.init.Items.getItemByName(baseName + "smallblend");
			Item smallpowder = fantasymetals.init.Items.getItemByName(baseName + "smallpowder");
			Item fishingrod = fantasymetals.init.Items.getItemByName(baseName + "fishingrod");
			Item horsearmor = fantasymetals.init.Items.getItemByName(baseName + "horsearmor");

			final Block button = fantasymetals.init.Blocks.getBlockByName(baseName + "button");
			final Item slab = fantasymetals.init.Items.getItemByName(baseName + "slab");
			final Block lever = fantasymetals.init.Blocks.getBlockByName(baseName + "lever");
			final Block pressure_plate = fantasymetals.init.Blocks.getBlockByName(baseName + "pressure_plate");
			final Item stairs = fantasymetals.init.Items.getItemByName(baseName + "stairs");
			final Block wall = fantasymetals.init.Blocks.getBlockByName(baseName + "wall");

			// NOTE: smelting XP is based on output item, not input item
			// ingot-related recipes
			if((ore != null) && (powder != null)) {
				CrusherRecipeRegistry.addNewCrusherRecipe("ore" + oreDictName, new ItemStack(powder, 2));
			}

			if((ore != null) && (ingot != null)) {
				GameRegistry.addSmelting(ore, new ItemStack(ingot, 1), metal.getOreSmeltXP());
			}

			if((ingot != null) && (powder != null)) {
				CrusherRecipeRegistry.addNewCrusherRecipe("ingot" + oreDictName, new ItemStack(powder, 1));
				GameRegistry.addSmelting(powder, new ItemStack(ingot, 1), metal.getOreSmeltXP());
			}

			if((ingot != null) && (blend != null)) {
				GameRegistry.addSmelting(blend, new ItemStack(ingot, 1), metal.getOreSmeltXP());
			}

			if((ingot != null) && (nugget != null)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(nugget, 9), new ItemStack(ingot)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), "xxx", "xxx", "xxx", 'x', "nugget" + oreDictName));
			}

			if((ingot != null) && (block != null)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ingot, 9), new ItemStack(block)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(block), "xxx", "xxx", "xxx", 'x', "ingot" + oreDictName));
			}

			if((ingot != null) && (plate != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plate, 3), "xxx", 'x', "ingot" + oreDictName));
				GameRegistry.addSmelting(plate, new ItemStack(ingot, 1), metal.getOreSmeltXP());
			}

			if((block != null) && (powder != null)) {
				CrusherRecipeRegistry.addNewCrusherRecipe("block" + oreDictName, new ItemStack(powder, 9));
			}

			if((ingot != null) && (bars != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bars, 16), "xxx", "xxx", 'x', "ingot" + oreDictName));
				OreDictionary.registerOre("bars", bars);
			}

			if((ingot != null) && (rod != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(rod, 4), "x", "x", 'x', "ingot" + oreDictName));
				OreDictionary.registerOre("stick" + oreDictName, rod);
//				OreDictionary.registerOre("rod" + oreDictName, rod);
				OreDictionary.registerOre("rod", rod);
			}

			if((nugget != null) && (rod != null)) {
				GameRegistry.addSmelting(rod, new ItemStack(nugget, 4), 0);
			}

			if((rod != null) && (bars != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bars, 4), "xxx", 'x', "rod" + oreDictName));
			}

			if((rod != null) && (ingot != null) && (gear != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(gear, 4), " x ", "x/x", " x ", 'x', "ingot" + oreDictName, '/', "rod" + oreDictName));
//				OreDictionary.registerOre("gear" + oreDictName, gear);
				OreDictionary.registerOre("gear", gear);

				if(metal == Materials.steel)
					OreDictionary.registerOre("sprocket", gear);
			}

			if((ingot != null) && (door != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(door, 3), "xx", "xx", "xx", 'x', "ingot" + oreDictName));
				OreDictionary.registerOre("door", door);
			}

			if((ingot != null) && (trapdoor != null)) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(trapdoor), "xx", "xx", 'x', "ingot" + oreDictName));
				OreDictionary.registerOre("trapdoor", trapdoor);
			}

			if((blend != null) && (smallblend != null)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(smallblend, 9), new ItemStack(blend)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blend), "xxx", "xxx", "xxx", 'x', new ItemStack(smallblend)));
				GameRegistry.addSmelting(smallblend, new ItemStack(nugget, 1), metal.getOreSmeltXP());
			}

			if((powder != null) && (smallpowder != null)) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(smallpowder, 9), new ItemStack(powder)));
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(powder), "xxx", "xxx", "xxx", 'x', new ItemStack(smallpowder)));
				GameRegistry.addSmelting(smallpowder, new ItemStack(nugget, 1), metal.getOreSmeltXP());
				CrusherRecipeRegistry.addNewCrusherRecipe("nugget" + oreDictName, new ItemStack(smallpowder, 1));
			}

			// armor and tools
			if((ingot != null) && (boots != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(boots), "x x", "x x", 'x', "ingot" + oreDictName));

			if((ingot != null) && (helmet != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(helmet), "xxx", "x x", 'x', "ingot" + oreDictName));

			if((ingot != null) && (chestplate != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chestplate), "x x", "xxx", "xxx", 'x', "ingot" + oreDictName));

			if((ingot != null) && (leggings != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(leggings), "xxx", "x x", "x x", 'x', "ingot" + oreDictName));

			if((ingot != null) && (axe != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe), "xx", "x/", " /", 'x', "ingot" + oreDictName, '/', "stickWood"));

//			if((ingot != null) && (axe != null))
//				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(axe), "xx", "/x", "/ ", 'x', "ingot" + oreDictName, '/', "stickWood"));

			if((block != null) && (crackhammer != null) && (!FantasyMetals.disableAllHammers))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crackhammer), "x", "/", "/", 'x', "block" + oreDictName, '/', "stickWood"));

			if((ingot != null) && (hoe != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe), "xx", " /", " /", 'x', "ingot" + oreDictName, '/', "stickWood"));

//			if((ingot != null) && (hoe != null))
//				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hoe), "xx", "/ ", "/ ", 'x', "ingot" + oreDictName, '/', "stickWood"));

			if((ingot != null) && (pickaxe != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pickaxe), "xxx", " / ", " / ", 'x', "ingot" + oreDictName, '/', "stickWood"));

			if((ingot != null) && (shovel != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shovel), "x", "/", "/", 'x', "ingot" + oreDictName, '/', "stickWood"));

			if((ingot != null) && (sword != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sword), "x", "x", "/", 'x', "ingot" + oreDictName, '/', "stickWood"));

			if((ingot != null) && (shears != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(shears), " x", "x " , 'x', "ingot" + oreDictName));

			if((rod != null) && (fishingrod != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fishingrod), "  x", " xy", "x y", 'x', "rod" + oreDictName, 'y', net.minecraft.init.Items.STRING));

			if((ingot != null) && (horsearmor != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(horsearmor), "  x", "xyx", "xxx", 'x', "ingot" + oreDictName, 'y', net.minecraft.init.Blocks.WOOL));

			// Bows and Crossbows
			if((rod != null) && (arrow != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(arrow, 4), "x", "y", "z", 'x', "nugget" + oreDictName, 'y', "rod" + oreDictName, 'z' ,net.minecraft.init.Items.FEATHER));

			if((rod != null) && (bow != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bow), " xy", "x y", " xy", 'x', "rod" + oreDictName, 'y', net.minecraft.init.Items.STRING));

			if((rod != null) && (gear != null) && (crossbow != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crossbow), "zxx", " yx", "x z", 'x', "rod" + oreDictName, 'y', "gear" + oreDictName, 'z', net.minecraft.init.Items.STRING));

			if((rod != null) && (bolt != null))
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(bolt, 4), "x", "x", "y", 'x', "rod" + oreDictName, 'y', net.minecraft.init.Items.FEATHER));

			if (nugget != null)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(button), "x", "x", 'x', "nugget" + oreDictName));

			if (block != null)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(slab, 6), "xxx", 'x', "block" + oreDictName));

			if ((block != null) && rod !=null)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(lever), "x", "y", 'x', "rod" + oreDictName, 'y', "block"  + oreDictName));

			if (ingot != null)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pressure_plate), "xx", 'x', "ingot" + oreDictName));

//			if (block != null) // Crashes
//				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stairs, 4), "x", "xx", "xxx", 'x', "block" + oreDictName));

			if (block != null)
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wall, 6), "", "", "", 'x', "block" + oreDictName));

		}

		// alloy blends
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fantasymetals.init.Items.template_blend, 2), "dustTemplate", "dustTemplate"));

		// small alloy blends
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fantasymetals.init.Items.template_smallblend, 2), "smalldustTemplate", "smalldustTemplate"));
	}

	/**
	 *
	 * @param oreDictEntries
	 * @param name
	 */
	public static void addOredicts(String[] oreDictEntries, Block name) {
		addOredicts(oreDictEntries, new ItemStack(name));
		//for(int i = 0; i < oreDictEntries.length; i++)
		//	OreDictionary.registerOre(oreDictEntries[i], name);
	}

	/**
	 *
	 * @param oreDictEntries
	 * @param name
	 */
	public static void addOredicts(String[] oreDictEntries, Item name) {
		addOredicts(oreDictEntries, new ItemStack(name));
		//for(int i = 0; i < oreDictEntries.length; i++)
		//	OreDictionary.registerOre(oreDictEntries[i], name);
	}

	/**
	 *
	 * @param oreDictEntries
	 * @param itemStackName
	 */
	public static void addOredicts(String[] oreDictEntries, ItemStack itemStackName) {
		//for(int i = 0; i < oreDictEntries.length; i++)
		//	OreDictionary.registerOre(oreDictEntries[i], itemStackName);
		for (final String oreDictEntry : oreDictEntries) {
			OreDictionary.registerOre(oreDictEntry, itemStackName);
		}
	}
}
