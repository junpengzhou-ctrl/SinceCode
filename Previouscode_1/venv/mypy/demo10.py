class Draw:
    def __init__(self,width,length):
        self.__width = width
        self.__length = length
    def Drawing(self):
        print('I can draw')
class showone(Draw):
    def Drawsquare(self):
        print('draw a square')
class showtwo(Draw):
    def DrawCricle(self):
        print('draw a cricle')
class showthree(showone,showtwo):
        pass
arter = Draw(6,8)
arter.Drawing()
arter1 = showthree(2,5)
arter1.Drawsquare()
arter1.DrawCricle()
print(showthree.__mro__)
print(isinstance(arter1,Draw))
print(arter1.__dict__)