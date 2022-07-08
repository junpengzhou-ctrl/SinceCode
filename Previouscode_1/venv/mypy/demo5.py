class Student:
    def __init__(self,sex,name,age):
        self.__sex = 'male'
        self.__name = name
        self.__age = age
    def func(self):
        print("-----------------")
        return self.__name
    def func2(self,value):
        print("+++++++++++++++")
        self.__name = value

    def func3(self):
        print("yyyyyyyyyyyyyyyyyyyy")
        del self.__name
    name = property(func,func2,func3,'Property:name')

a = Student('zs',10)
print(a.name)
a.name = "waw"