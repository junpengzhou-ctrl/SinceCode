from matplotlib import pyplot as plt
import matplotlib as mpl

mpl.style.use('ggplot')

labels = 'Frogs', 'Hogs', 'Dogs', 'Logs'
data = [15, 30, 45, 10]
explode = (0, 0.2, 0, 0)  # explode the 2nd slice (i.e. 'Hogs')

fig, ax = plt.subplots()
ax.pie(data, explode=explode, labels=labels,
       autopct='%1.1f%%', shadow=True, startangle=90)
ax.axis('equal')  # drawn as a circle.

plt.show()
