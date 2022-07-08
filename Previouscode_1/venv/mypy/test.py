import numpy as np
s =np.array([10,20,30],dtype='U2')
print(s.ndim)#轴的个数
print(s.shape) #维度，即函数和列数构成的元祖
print(s.size)   #元素总个数
print(s.dtype) #元素类型
print(s.itemsize) #元素字节的大小
print('----------------------------')
s =np.array([[1,2,3],[4,5,6]],dtype='f8')
print(s.ndim)#轴的个数
print(s.shape) #维度，即函数和列数构成的元祖
print(s.size)   #元素总个数
print(s.dtype) #元素类型
print(s.itemsize) #元素字节的大小
np.array([10,20,30],dtype=[('age',np.int8)])

