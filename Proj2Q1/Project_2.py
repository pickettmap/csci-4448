import random

class Animal:
	
	def __init__(self, name):
		self.name = name
		self.roam_behavior = RoamBehavior()
		self.species = self.__class__.__name__

	def getName(self):
		return self.name
	
	def sleep(self):
		print(self.name+ " the "+ self.species + " is sleeping")
		
	def wakeUp(self):
		print(self.name+ " the "+ self.species + " is awake")
		
	def eat(self):
		print(self.name+ " the "+ self.species + " is eating")
		
	#Strategy Pattern
	def performRoam(self):
		self.roam_behavior.roam(self.name, self.species)

#Roaming Interface
class RoamBehavior:
	def roam(self,name,species):
		print("Default roam behavior")
		
#Run Behavior	
class Run(RoamBehavior):
	def roam(self,name,species):
		print(name+" the "+species+" is running")

#Stalk Behavior
class Stalk(RoamBehavior):
	def roam(self,name,species):
		print(name+" the "+species+" is stalking")

#Walk Behavior
class Walk(RoamBehavior):
	def roam(self,name,species):
		print(name+" the "+species+" is walking")
		
class Pachyderm(Animal):
	#Set roam behavior to walk
	def __init__(self,name):
		super().__init__(name)
		self.roam_behavior = Walk()
		
class Feline(Animal):
	#Set roam behavior to stalk
	def __init__(self, name):
		super().__init__(name)
		self.roam_behavior = Stalk()
		
class Canine(Animal):
	#Set roam behavior to run
	def __init__(self, name):
		super().__init__(name)
		self.roam_behavior = Run()
		
class Hippo(Pachyderm):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " says Hello")
		
class Elephant(Pachyderm):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " trumpets")

class Rhino(Pachyderm):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " says what's up")
		
class Tiger(Feline):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " growls")

class Lion(Feline):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " roars")

class Cat(Feline):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		#print(self.name+ " the "+ self.__class__.__name__ + " growls")
		
		x  = random.randrange(0,3,1)
		if(x==0):
			print(self.name+ " the "+ self.__class__.__name__ + " meows")
		elif(x==1):
			print(self.name+ " the "+ self.__class__.__name__ + " purrs")
		else:
			print(self.name+ " the "+ self.__class__.__name__ + " hisses")

class Wolf(Canine):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " howls")

class Dog(Canine):
	def __init__(self, name):
		super().__init__(name)
		
	def makeNoise(self):
		print(self.name+ " the "+ self.__class__.__name__ + " barks")

#ZooAnnouncer for Observer Pattern
class ZooAnnouncer:
	#Prints to system when zookeeper has done something (status changed)
	def update(self,status):
		output = "Hi, this is the Zoo Announcer. "
		if(status=="wake"):
			output = output + "The Zookeeper is about to wake the animals!"
		if(status=="rollcall"):
			output = output + "The Zookeeper is about to call the animals!"
		if(status=="feed"):
			output = output + "The Zookeeper is about to feed the animals!"
		if(status=="exercise"):
			output = output + "The Zookeeper is about to exercise the animals!"
		if(status=="shutdown"):
			output = output + "The Zookeeper is about to shutdown the zoo!"
		print(output)
	
	#deconstructor
	def __del__(self): 
		print("This is the Zoo Announcer, I'm going home!") 
		
			
class Zookeeper():
	#Setting up observer for observer pattern
	def __init__(self):
		self.zoo_announcer = ZooAnnouncer()
		self.status_ = None
		
	#Tells zooannouncer to update
	def notifyObservers(self):
		self.zoo_announcer.update(self.status_)
		
	#Called whenever status is changed after something is done
	def statusChanged(self):
		self.notifyObservers()
		
	#Called whenever zookeeper does something
	def setStatus(self,status):
		self.status_=status
		self.statusChanged()
		
	def wakeUp(self,Zoo):
		self.setStatus("wake")
		print("Zookeeper here! Now waking up the zoo")
		for animal in Zoo:
			animal.wakeUp()
			
	def rollCall(self,Zoo):
		self.setStatus("rollcall")
		print("Zookeeper here! Now doing rollcall")
		for animal in Zoo:
			animal.makeNoise()
	
	def feed(self, Zoo):
		self.setStatus("feed")
		print("Zookeeper here! Now feeding the zoo")
		for animal in Zoo:
			animal.eat()
			
	def exercise(self, Zoo):
		self.setStatus("exercise")
		print("Zookeeper here! Now exercising the zoo")
		for animal in Zoo:
			animal.performRoam()
			
	def shutDownZoo(self, Zoo):
		self.setStatus("shutdown")
		print("Zookeeper here! Now shutting down the zoo")
		for animal in Zoo:
			animal.sleep()
		del self.zoo_announcer
	
def main():
	hippo1 = Hippo("Henry")
	hippo2 = Hippo("Harry")
	elephant1 = Elephant("Eli")
	elephant2 = Elephant("Elijah")
	rhino1 = Rhino("Rachel")
	rhino2 = Rhino("Ryan")
	tiger1 = Tiger("Tony")
	tiger2 = Tiger("Tom")
	lion1 = Lion("Leo")
	lion2 = Lion("Lucy")
	cat1 = Cat("Chris")
	cat2 = Cat("Chloe")
	wolf1 = Wolf("Will")
	wolf2 = Wolf("Wendy")
	dog1 = Dog("David")
	dog2 = Dog("Dan")
	zoo = [hippo1,hippo2,elephant1,elephant2,rhino1,rhino2,tiger1,tiger2,lion1,lion2,cat1,cat2,wolf1,wolf2,dog1,dog2]
	
	test2 = Zookeeper()
	test2.wakeUp(zoo)
	test2.rollCall(zoo)
	test2.feed(zoo)
	test2.exercise(zoo)
	test2.shutDownZoo(zoo)

main()