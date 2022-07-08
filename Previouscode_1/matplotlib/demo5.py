import numpy as np
from matplotlib import pyplot as plt
x = np.linspace(0, 2*np.pi, 100)

fig, axes = plt.subplots(2, 2, subplot_kw=dict(polar=True) )
axes[0, 0].plot(x, np.sin(x), label='sin')
axes[0, 1].plot(x, np.tan(x), label='tan')
axes[1, 0].scatter(x, np.arctan(x), label='atan')
axes[1, 1].scatter(x, np.cos(x), label='cos')

axes[0, 0].legend(loc='lower right')
axes[0, 1].legend(loc='lower left')
axes[1, 0].legend(loc='upper right')
axes[1, 1].legend(loc='upper left')

plt.show()
