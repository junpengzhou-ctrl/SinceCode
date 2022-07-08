class A :
    type=3
    def f1(self):
        print(type)    	# Comment out type=xxx, see what is printed
        print(self.type)  # There are total 4 of them, try different combination
class B : 		# Also comment out all of them
    type=4
    pass
class C(A, B) :
    type=2
    pass
c = C()
c.type=1  #同名变量优先于方法
c.f1()