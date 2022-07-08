# class A:
#     def func1(x):
#         print('xxxx')
# class B:
#     def func1(self):
#         print('xxxxxxxxxxxxxxxxxx')
# class C(A,B):
#     pass
# a = A()
# b = B()
# print(isinstance(a,A))
# print(isinstance(b,B))
# print(isinstance(A,C))
# print(isinstance(C,B))
# def cal(x):
#     x.func1()
# cal(b)

class A:
    def __init__(self):  #初始化
        self.name = 'zx'
        self.age = 15
        print('-----------------')
    def __new__(cls, *args, **kwargs):  #创建对象实例
        print('++++++++++=')
        return super(A,cls).__new__(cls)
    # def __del__(self):
    #     print('*********************')
a = A()
print(a.__dict__)   #类名
print(a.__dict__['name'])
print(A.__bases__)
