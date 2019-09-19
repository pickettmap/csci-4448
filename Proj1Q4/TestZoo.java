import java.util.*;

class Animal
{
    private Boolean is_awake_;
    
    //Protected so sublcasses can access name easily.
    protected String name_;
    
    public void setName(String name)
    {
        name_=name;
    }
    
    public String getName()
    {
        return name_;
    }
    
    public void sleep()
    {
        is_awake_=false;
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is sleeping");
    }
    
    public void wakeup()
    {
        is_awake_=true;
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is awake");
    }
    
    public void eat()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is eating");
    }
    
    public void makeNoise(){};
    public void roam(){};

}

class Pachyderm extends Animal
{
    public void roam()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is roaming");
    }
}

class Feline extends Animal
{
    public void roam()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is roaming");
    }
}

class Canine extends Animal
{
    public void roam()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" is roaming");
    }
}

class Hippo extends Pachyderm
{
    //Overloaded constructor setting protected name to input string
    //Subclasses cannot easily inherit constructors from superclass, so each subclass has its own constructor
    public Hippo(String name)
    {
        name_=name;
    }
    
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" says hello");
    }
}

class Elephant extends Pachyderm
{
    public Elephant(String name)
    {
        name_=name;
    }
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" trumpets");
    }
}

class Rhino extends Pachyderm
{
    public Rhino(String name)
    {
        name_=name;
    }
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" says what's up");
    }
}

class Tiger extends Feline
{
    public Tiger(String name)
    {
        name_=name;
    }
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" growls");
    }
}

class Lion extends Feline
{
    public Lion(String name)
    {
        name_=name;
    }
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" roars");
    }
}

class Cat extends Feline
{
    public Cat(String name)
    {
        name_=name;
    }
    
    //Cat makes a random noise
    //Generate random int between [0,2], use switch case to determine output
    public void makeNoise()
    {
        Random rand = new Random();
        int n = rand.nextInt(3);
           
        switch(n)
        {
            case 0:
                System.out.println(name_+" the "+this.getClass().getSimpleName()+" meows");
                break;
            case 1:
                System.out.println(name_+" the "+this.getClass().getSimpleName()+" purrs");
                break;
            case 2:
                System.out.println(name_+" the "+this.getClass().getSimpleName()+" hisses");
                break;
           }
    }
}

class Wolf extends Canine
{
    public Wolf(String name)
    {
        name_=name;
    }
    
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" howls");
    }
}

class Dog extends Canine
{
    public Dog(String name)
    {
        name_=name;
    }
    public void makeNoise()
    {
        System.out.println(name_+" the "+this.getClass().getSimpleName()+" barks");
    }
}

class Zookeeper
{
    //Waking up zoo, for each animal in the zoo, call their wakeup function
    public void wakeUp(List<Animal> zoo)
    {
        System.out.println("Waking up the zoo");
        for(Animal temp : zoo)
        {
            temp.wakeup();
        }
    }
    
    //Doing roll call, for each animal, have them make a noise
    public void rollCall(List<Animal> zoo)
    {
        System.out.println("Doing rollcall");
        for(Animal temp : zoo)
        {
            temp.makeNoise();
        }
    }
    
    //Feeding zoo
    public void feed(List<Animal> zoo)
    {
        System.out.println("Feeding the zoo");
        for(Animal temp : zoo)
        {
            temp.eat();
        }
    }
    
    //Exercising zoo, for each animal in zoo, have them roam
    public void exercise(List<Animal> zoo)
    {
        System.out.println("Exercising the zoo");
        for(Animal temp : zoo)
        {
            temp.roam();
        }
    }
    
    //Shutting down zoo, for each animal, put them to sleep
    public void shutDownZoo(List<Animal> zoo)
    {
        System.out.println("Shutting down the zoo");
        for(Animal temp : zoo)
        {
            temp.sleep();
        }
    }
}

public class TestZoo
{
    public static void main(String args[])
    {
        //Creating list of animals
        List<Animal> zoo = new ArrayList<Animal>();
       
        //Instantiating animals
        Animal hippo1 = new Hippo("Henry");
        Animal hippo2 = new Hippo("Harry");
        Animal elephant1 = new Elephant("Eli");
        Animal elephant2 = new Elephant("Elijah");
        Animal rhino1 = new Rhino("Ray");
        Animal rhino2 = new Rhino("Rachel");
        Animal tiger1 = new Tiger("Tony");
        Animal tiger2 = new Tiger("Tom");
        Animal lion1 = new Lion("Leo");
        Animal lion2 = new Lion("Lucy");
        Animal cat1 = new Cat("Chris");
        Animal cat2 = new Cat("Chloe");
        Animal wolf1 = new Wolf("Will");
        Animal wolf2 = new Wolf("Wendy");
        Animal dog1 = new Dog("David");
        Animal dog2 = new Dog("Dan");

        //Populating zoo
        zoo.add(hippo1);
        zoo.add(hippo2);
        zoo.add(elephant1);
        zoo.add(elephant2);
        zoo.add(rhino1);
        zoo.add(rhino2);
        zoo.add(tiger1);
        zoo.add(tiger2);
        zoo.add(lion1);
        zoo.add(lion2);
        zoo.add(cat1);
        zoo.add(cat2);
        zoo.add(wolf1);
        zoo.add(wolf2);
        zoo.add(dog1);
        zoo.add(dog2);
        
        //Instantiating zookeeper
        Zookeeper Noah = new Zookeeper();
        
        //running zoo
        Noah.wakeUp(zoo);
        Noah.rollCall(zoo);
        Noah.feed(zoo);
        Noah.exercise(zoo);
        Noah.shutDownZoo(zoo);
    }
}

