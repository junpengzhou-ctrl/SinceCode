from matplotlib import pyplot as plt
import numpy as np
x = np.linspace(0, 2*np.pi, 100)

fig, (ax1,ax2) = plt.subplots(2,1, sharex=True)
ax1.plot(x,  np.sin(x), label="sin")
ax1.legend(loc='upper center', shadow=True)
ax2.scatter(x, np.cos(x), label='cos')
ax2.legend(loc='upper center', shadow=True)

ax1.set_title("Subplots Demo")
ax1.set_ylabel("y")
ax2.set_xlabel("x")
plt.show()
