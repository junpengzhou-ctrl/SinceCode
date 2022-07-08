import pandas as pd
x = [[1,2],[3,4]]
d = pd.DataFrame(x,index=['a','b'],columns=['e','f'])     #行标签和列标签
print(d)
m = [{'a': 1, 'b': 2}, {'a': 3, 'b': 4, 'c': 5}]
d = {'data':m}
print(type(d))
