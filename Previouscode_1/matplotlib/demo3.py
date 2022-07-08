from matplotlib import pyplot as plt
import matplotlib as mpl
mpl.style.use('default')

data1 = [1,2,2,2,2,2,2,2,2,3,3,4,5,6,7,8,9,10,14]
data2 = [1,2,3,4,5,6,7,7,7,7,7,7,8,9,10,10,10,10,10]

fig, ax = plt.subplots()

ax.hist([data1, data2], bins=7, label=['D1','D2'], stacked=True)
ax.legend()
plt.show()
