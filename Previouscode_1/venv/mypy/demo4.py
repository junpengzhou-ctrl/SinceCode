class Student:
    __banji = 'hah'
    def __init__(self,name,age):
        self.name = name
        self.age = age
        @property
        def name(self):
            return self.__name
        @name.setter
        def name(self,value):
            self.__name = value
        @name.deleter
        def name(self):
            print('------------------')
            del self.__name
a= Student("zs",25)
#del a.name
a.score = 'xixi'
print(a.score)