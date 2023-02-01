package net.epicreoncore.utils;

import net.epicreoncore.EpicReonCore;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class SimpleItem extends ItemStack {
    ItemMeta itemMeta = this.getItemMeta();

    public SimpleItem(Material material , String displayName , String lore) {
        super(material);
        itemMeta.setDisplayName(EpicReonCore.format(displayName));
        itemMeta.setLore(Collections.singletonList(EpicReonCore.format(lore)));
        this.setItemMeta(itemMeta);
    }

    public SimpleItem setDisplayName(String displayName) {
        itemMeta.setDisplayName(EpicReonCore.format(displayName));
        this.setItemMeta(itemMeta);

        return this;
    }

    public SimpleItem setEnchantment(Enchantment enchantment , int level) {
        itemMeta.addEnchant(enchantment , level , true);
        this.setItemMeta(itemMeta);

        return this;
    }
}
