class animal:
    def __init__(self,name,age):
        self.__name = name
        self.__age = age
    @property              #负责把一个方法变成属性调用.
    def get_age_fun(self):
        return self.__age
    @get_age_fun.setter
    def get_age_fun(self,value):
        self.__age = value
    def print_info(self):
        print(self.__name,self.__age)
ani = animal("huahua",6)
#ani.get_age_fun =2
print(ani.get_age_fun)  #通过类的属性来定义类的方法
ani.print_info()
