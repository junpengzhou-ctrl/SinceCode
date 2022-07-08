import numpy as np
a = np.arange(0,40)
print(a.reshape(4,2,5))
for v in np.nditer(a,order ='F'):
    print(v)

s = np.arange(12).reshape(2,3,2)
#range是默认从0开始的
print(s)
print('----------------------------------')
print(np.concatenate((s,s)))  #
print('---------------------------')
print(np.append(s,s))  #在s后面再追加s
print('++++++++++++++++++++++++')
print(np.delete(s,1,0))