import java.util.*;

public class HardwareStore
{
	public static void main(String args[])
	{
		Tool ptool = new PaintingTool("Paint Tool1");
		System.out.println(ptool.getDescription() + " $" + ptool.cost());
		
// 		Tool ctool = new ConcreteTool("Concrete Tool1");
// 		ctool = new ExtensionCord(ctool);
// 		System.out.println(ctool.getDescription() + "$" + ctool.cost());
	}
}

//----------------------------Basic Tool Objects----------------------------
abstract class Tool {
	public String name;
	public String type;
	protected int cost;

	public Tool(String name) {
		this.name = name;
	}
	public abstract int cost();
	public String getDescription()
	{
		return type;
	}
}

class PaintingTool extends Tool {
	public String name;
	public String type;
	protected int cost;
	public PaintingTool(String name) {
		super(name);
		this.type="Painting Tool";
		this.cost = 5;
	}
	public int cost() {
		return this.cost;
	}
}

// class ConcreteTool extends Tool {
// 	public String name;
// 	public String type;
// 	protected int cost;
// 	public ConceteTool(String name) {
// 		super(name);
// 		this.type="Concrete Tool";
// 		this.cost = 20;
// 	}
// 	public int cost() {
// 		return this.cost;
// 	}
// }

class PlumbingTool extends Tool {
	public String name;
	public String type;
	protected int cost;
	public PlumbingTool(String name) {
		super(name);
		this.type="Plumbing Tool";
		this.cost = 10;
	}
	public int cost() {
		return this.cost;
	}
}

class WoodworkTool extends Tool {
	public String name;
	public String type;
	protected int cost;
	public WoodworkTool(String name) {
		super(name);
		this.type="Woodwork Tool";
		this.cost = 15;
	}
	public int cost() {
		return this.cost;
	}
}

class YardworkTool extends Tool {
	public String name;
	public String type;
	protected int cost;
	public YardworkTool(String name) {
		super(name);
		this.type="Yardwork Tool";
		this.cost = 20;
	}
	public int cost() {
		return this.cost;
	}
}

//----------------------------Basic Tool Objects----------------------------
abstract class ToolDecorator extends Tool{
	protected Tool tool;
	public ToolDecorator(Tool tool) {
		this.tool = tool;
	}
	public abstract String getDescription();	
}

class ExtensionCord extends ToolDecorator{
	protected Tool tool;
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
Tool tool;
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
	Tool tool;
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
