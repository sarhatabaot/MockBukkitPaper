package be.seeseemelk.mockbukkit;

import com.google.common.collect.Multimap;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainComponentSerializer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.UnsafeValues;
import org.bukkit.advancement.Advancement;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.PluginDescriptionFile;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import io.papermc.paper.inventory.ItemRarity;

@SuppressWarnings("deprecation")
public class MockUnsafeValues implements UnsafeValues
{
	private static final Pattern LOCALIZATION_PATTERN = Pattern.compile("%(?:(\\d+)\\$)?s");
	public static final ComponentFlattener FLATTENER = ComponentFlattener.basic().toBuilder()
	        .build();
	public static final LegacyComponentSerializer LEGACY_SECTION_UXRC = LegacyComponentSerializer.builder().flattener(FLATTENER).hexColors().useUnusualXRepeatedCharacterHexFormat().build();
	public static final PlainComponentSerializer PLAIN = PlainComponentSerializer.builder().flattener(FLATTENER).build();
	public static final GsonComponentSerializer GSON = GsonComponentSerializer.builder()
	        /*.legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.INSTANCE)*/
	        .build();
	public static final GsonComponentSerializer COLOR_DOWNSAMPLING_GSON = GsonComponentSerializer.builder()
	        /*.legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.INSTANCE)*/
	        .downsampleColors()
	        .build();
	private final Set<String> compatibleApiVersions = new HashSet<>(Arrays.asList("1.13", "1.14", "1.15", "1.16", "1.17"));

	@Override
	public ComponentFlattener componentFlattener()
	{
		// TODO: Translatable
		return FLATTENER;
	}

	@Override
	public PlainComponentSerializer plainComponentSerializer()
	{
		return PLAIN;
	}

	@Override
	public GsonComponentSerializer gsonComponentSerializer()
	{
		return GSON;
	}

	@Override
	public GsonComponentSerializer colorDownsamplingGsonComponentSerializer()
	{
		return COLOR_DOWNSAMPLING_GSON;
	}

	@Override
	public LegacyComponentSerializer legacyComponentSerializer()
	{
		return LEGACY_SECTION_UXRC;
	}

	@Override
	public void reportTimings()
	{

	}

	@Override
	public Material toLegacy(Material material)
	{
		if (material.isLegacy())
		{
			return material;
		}
		throw new UnimplementedOperationException();
	}

	@Override
	public Material fromLegacy(Material material)
	{
		return material;
	}

	@Override
	public Material fromLegacy(MaterialData material)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public Material fromLegacy(MaterialData material, boolean itemPriority)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public BlockData fromLegacy(Material material, byte data)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public int getDataVersion()
	{
		return 1;
	}

	@Override
	public ItemStack modifyItemStack(ItemStack stack, String arguments)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public void checkSupported(PluginDescriptionFile pdf) throws InvalidPluginException
	{
		if (pdf.getAPIVersion() == null)
			throw new InvalidPluginException("Plugin does not specify 'api-version' in plugin.yml");

		if (!compatibleApiVersions.contains(pdf.getAPIVersion()))
			throw new InvalidPluginException(String.format("Plugin api version %s is incompatible with the current MockBukkit version", pdf.getAPIVersion()));
	}

	@Override
	public byte[] processClass(PluginDescriptionFile pdf, String path, byte[] clazz)
	{
		return clazz;
	}

	@Override
	public Advancement loadAdvancement(NamespacedKey key, String advancement)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public boolean removeAdvancement(NamespacedKey key)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public String getTimingsServerName()
	{
		return null;
	}

	@Override
	public boolean isSupportedApiVersion(String apiVersion)
	{
		return false;
	}

	@Override
	public byte[] serializeItem(ItemStack item)
	{
		return new byte[0];
	}

	@Override
	public ItemStack deserializeItem(byte[] data)
	{
		return null;
	}

	@Override
	public String getTranslationKey(Material mat)
	{
		return null;
	}

	@Override
	public String getTranslationKey(Block block)
	{
		return null;
	}

	@Override
	public String getTranslationKey(EntityType type)
	{
		return null;
	}

	@Override
	public String getTranslationKey(ItemStack itemStack)
	{
		return null;
	}

	@Override
	public int nextEntityId()
	{
		return 0;
	}

	@Override
	public ItemRarity getItemRarity(Material material)
	{
		return null;
	}

	@Override
	public ItemRarity getItemStackRarity(ItemStack itemStack)
	{
		return null;
	}

	@Override
	public boolean isValidRepairItemStack(@NotNull ItemStack itemToBeRepaired, @NotNull ItemStack repairMaterial)
	{
		return false;
	}

	@Override
	public @NotNull Multimap<Attribute, AttributeModifier> getItemAttributes(@NotNull Material material, @NotNull EquipmentSlot equipmentSlot)
	{
		return null;
	}

	@Override
	public int getProtocolVersion()
	{
		return 0;
	}

	@Override
	public Material getMaterial(String material, int version)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

}
