class Math:
    @staticmethod
    def factoral(n):
        if n<2:return n
        return Math.factoral(n -1)*n
print(Math.factoral(5))

class Student:
    @classmethod
    def func(cls):
        print('-----------')
Student.func()
