class Shape:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def move(self,x,y):
        self.x +=x
        self.y +=y
s = Shape(1,3)
print(s.x)
s.move(2,4)
print(s.x)
Shape.move(s,x=1,y=3)

class Student:
    def __init__(self,name,age,level):
        self.name = name
        self.age = age
        self.level = level
stu = Student("zs",18,"6")

Shape.fn = lambda self,x:x*x
s = Shape(1,2)
print(s.fn(3))
s.move(10,10)
#del  Shape.move
s.move()

