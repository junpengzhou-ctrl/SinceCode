import numpy as np
import matplotlib.pyplot as plt
# fg,ax = plt.subplots(2,2)  #第一个变量是画布，第二个变量是子图
# # ax.plot([1,2,3,4,5])
# # plt.show()
# ax[0][0].plot(x,y)
# plt.show()


def f(t):
    return np.exp(-t) * np.cos(2 * np.pi * t)


t1 = np.arange(0.0, 5.0, 0.1)
t2 = np.arange(0.0, 5.0, 0.02)

plt.figure("2subplot")
plt.subplot(211)
plt.plot(t1, f(t1), 'bo', t2, f(t2), 'k')

plt.subplot(212)
plt.plot(t2, np.cos(2 * np.pi * t2), 'r--')
plt.show()
