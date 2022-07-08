import numpy as np
a = np.array([1,2,3])     #一维
a = np.array([[1,2,3],[4,5,6]])   #二维
a = np.array([[1,2,3],[4,5,6],[2,3,4]])   #二维 因为在0维有三个，1维有三个
a = np.array([[[1,2,3],[5,2,3],[7,8,9]],[[4,5,6],[4,5,6],[7,8,9]]])   #三维
print(a)
print("---------------------------数组基本概念------------------------------")
print("数组元素类型",a.dtype)
print("数组的形状",a.shape)
print("数组的轴个数",a.ndim)
print("数组元素总个数",a.size)
print("数组元素大小",a.itemsize)
print("-----------------------以下创建数组基本操作----------------------------")
s =np.empty([6,7],dtype='U4')
print(s)
t =np.zeros([3,4])   #全是零的ndarray 默认float64
print(t)
m = np.ones([3,4],dtype='U4')  #常用
print(m)
n = np.arange(0,4,2)  #左开右闭
print(n)
l = np.full([3,4],7)   #用7填充
print(l)
print(np.eye(5))
print(np.random.random([3,4]))  #生成随机数组
print(np.linspace(4,6,3)) #4到6生成3段
print("-----------------------以下是转变维度--------------------------")
c = np.array([[1,2,3],[4,5,6],[2,3,4]])
print(c.shape)

sn = np.reshape(c,(9,1,1))  #变换条件是元素的形成乘积是一样的
print(sn)
sn.flatten() #展开 成为一维数组

print(c[2])   #取第二个坐标元素
print(c[:,2])   #o维度数组都取
print(c[:2,1:3])
print("--------------------遍历数组------------------------")
for v in np.nditer(c,order ='F'):
    print(v)
#concatenate 拼接append 在维度上追加

# a = np.arange().reshape(2,3,1)
# b = np.arange().reshape(1,2)
# print(a)
# print(b)
print(np.max(c,axis=1))

