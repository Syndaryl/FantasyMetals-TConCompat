package fantasymetals.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cyano.basemetals.init.FunctionalCreativeTab;
import fantasymetals.FantasyMetals;
import fantasymetals.init.Items;

/**
 * This class initializes all item groups in Modern Metals.
 * @author DrCyano
 *
 */
public class ItemGroups extends cyano.basemetals.init.ItemGroups {

	public static CreativeTabs tab_blocks;
	public static CreativeTabs tab_items;
	public static CreativeTabs tab_tools;

	private static Item blockItem;
//	private static Item itemItem;
//	private static Item toolItem;
	
	private static boolean initDone = false;
	public static void init(){
		if(initDone) return;
		
		// placeholder's
		blockItem = Items.template_crackhammer;
//		itemItem = Items.template_crackhammer;
//		toolItem = Items.template_crackhammer;

		tab_blocks = new FunctionalCreativeTab( FantasyMetals.MODID.concat(".blocks"), false,
				()->Items.template_crackhammer, 
				(ItemStack a,ItemStack b)->{
					int delta = Items.getSortingValue(a)-Items.getSortingValue(b);
					if(delta == 0) return a.getItem().getUnlocalizedName().compareToIgnoreCase(b.getItem().getUnlocalizedName());
					return delta;
				});
//		tab_items = new FunctionalCreativeTab( FantasyMetals.MODID.concat(".items"),()->itemItem);
//		tab_tools = new FunctionalCreativeTab( FantasyMetals.MODID.concat(".tools"),()->toolItem);
		tab_items = tab_blocks;
		tab_tools = tab_items;
		
		
		initDone = true;
	}
}
