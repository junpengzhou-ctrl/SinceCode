class Student:
    banji = 'KB01'  #静态的
    def __init__(self,name,age):
        self.name = name
        self.age  = age


    def updateVar(self):
        self.banji = 'HAHA'
print(Student.banji)
stu = Student('zsd',15)
print(stu.banji)

Student.updateVar()
print(Student.banji)