import numpy as np
import matplotlib.pyplot as plt
x =np.linspace(0.0,5.0)        #linspace 矢量
y1 = np.sin(np.pi*x)
y2 = np.sin(np.pi*x*2)
plt.subplot(2,1,1)              #subplot切成两行一列
plt.plot(x,y1,'<m',label = 'sin(pi*x)')
# plt.ylabel('y1 value')
plt.subplot(2,1,2)
plt.plot(x,y2,'g--',label = 'sin(pi*2x)')
# plt.ylabel('y2 value')
# plt.xlabel('x label')
plt.show()

