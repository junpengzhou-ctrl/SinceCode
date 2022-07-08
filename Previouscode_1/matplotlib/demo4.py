import numpy as np
from matplotlib import pyplot as plt
import matplotlib as mpl
mpl.style.use('fivethirtyeight')
n=10
xs = np.linspace(0.0, 2 * np.pi, n)
ys = 10 * np.random.rand(n)
widths = np.pi / 4 * np.random.rand(n)

fig, ax = plt.subplots(subplot_kw=dict(polar=True))
bars = ax.bar(xs, ys, width=widths)
for y, bar in zip(ys, bars):   # custom color and opacity
    bar.set_facecolor(plt.cm.plasma(y / 10.))
    bar.set_alpha(0.5)
plt.show()
