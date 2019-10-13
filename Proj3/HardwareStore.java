//not github
import java.util.*;

public class HardwareStore
{
	public static void main(String args[])
	{
		Tool ptool = new PaintingTool("Paint Tool1");
		System.out.println(ptool.getDescription() + " $" + ptool.cost());
		
 		Tool ctool = new ConcreteTool("Concrete Tool1");
 		ctool = new ExtensionCord(ctool);
 		System.out.println(ctool.getDescription() + " $" + ctool.cost());
	}
}

//----------------------------Basic Tool Objects----------------------------
interface Tool {
	public int cost();
	public String getDescription();
}

class PaintingTool implements Tool {
	public String name;
	public String type;
	protected int cost;
	public PaintingTool(String name) {
		this.name = name;
		this.type = "Painting Tool";
		this.cost = 5;
	}
	public int cost() {
		return this.cost;
	}
	public String getDescription() {
		return this.type;
	}
}

class ConcreteTool implements Tool {
	public String name;
	public String type;
	protected int cost;
	public ConcreteTool(String name) {
		this.name = name;
		this.type = "Concrete Tool";
		this.cost = 20;
	}
	public int cost() {
		return this.cost;
	}
	public String getDescription() {
		return this.type;
	}
}

class PlumbingTool implements Tool {
	public String name;
	public String type;
	protected int cost;
	public PlumbingTool(String name) {
		this.name = name;
		this.type = "Concrete Tool";
		this.cost = 15;
	}
	public int cost() {
		return this.cost;
	}
	public String getDescription() {
		return this.type;
	}
}

class WoodworkTool implements Tool {
	public String name;
	public String type;
	protected int cost;
	public WoodworkTool(String name) {
		this.name = name;
		this.type = "Concrete Tool";
		this.cost = 15;
	}
	public int cost() {
		return this.cost;
	}
	public String getDescription() {
		return this.type;
	}
}

class YardworkTool implements Tool {
	public String name;
	public String type;
	protected int cost;
	public YardworkTool(String name) {
		this.name = name;
		this.type = "Concrete Tool";
		this.cost = 10;
	}
	public int cost() {
		return this.cost;
	}
	public String getDescription() {
		return this.type;
	}
}

//----------------------------Basic Tool Objects----------------------------
abstract class ToolDecorator implements Tool {
	protected Tool tool;
	public ToolDecorator(Tool tool) {
		this.tool = tool;
	}
}

class ExtensionCord extends ToolDecorator {
	public ExtensionCord(Tool tool)
	{
		super(tool);
	}

	public String getDescription()
	{
		return tool.getDescription() + ", Extension Cord";
	}

	public int cost()
	{
		return 1 + tool.cost();
	}
}

class AccessoryKit extends ToolDecorator{
	public AccessoryKit(Tool tool)
	{
		super(tool);
	}

	public String getDescription()
	{
		return tool.getDescription() + ", Accessory Kit";
	}

	public int cost()
	{
		return 2 + tool.cost();
	}
}

class ProtectiveGearPackage extends ToolDecorator{
	public ProtectiveGearPackage(Tool tool)
	{
		super(tool);
	}

	public String getDescription()
	{
		return tool.getDescription() + ", Protective Gear";
	}

	public int cost()
	{
		return 3 + tool.cost();
	}
}

