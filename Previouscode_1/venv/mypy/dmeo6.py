# class D:
#     def f1(self):
#         print('D')
# class E:
#     def f1(self):
#         print('E')
# class F:
#     def f1(self):
#         print('F')
# class B(E,D):
#     def f1(self):
#         print('B')
# class C(D,F):
#     def f1(self):
#         print('C')
# class A(B,c):
#     def f1(self):
#         print('A')

class A:
    def f1(self):
        print('A.f1\n')

    def f2(self):
        print('A.f2\n')
class B:
    def f1(self):
        print('A.f1\n')
class C(A,B):
    def f2(self):
        print('C.f2\n')
c= C()
c.f1()
c.f2()
print(C.mro())

