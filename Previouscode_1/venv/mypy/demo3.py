class animal:
    def __init__(self,name,color):
        self.__name = name
        self.color = color

    def getName(self):
        return self.__name
    @classmethod
    def speak(cls):
        cls.color = "yellow"
        cls.name = "huhua"
    @staticmethod
    def eat():
        print("I can eat")
animal.speak()
a = animal("zs","yellow")
print(a.getName())
