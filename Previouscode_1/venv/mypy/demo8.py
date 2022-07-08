import numpy as np
import pandas as pd

import matplotlib as mlt

class Student:
    def __init__(self,name,age):
        self.__sex = 'male'
        self.__name = name
        self.__age = age
    def __str__(self):
        return 'name:{0},age:{1}'.format(self.__name,self.__age)
    def __eq__(self, other):
        print('+++++++++++')
        return self.__age ==other.__age and self.__name ==self.__name
    def __len__(self):
        return  8
a = Student('zhang','16')
b = Student('zhang','16')
# print(a)
print(str(a))
print(a ==b)

class M:
    def __init__(self,x):
        self.x = x

m = [1,2,3,4]
print(len(a))
