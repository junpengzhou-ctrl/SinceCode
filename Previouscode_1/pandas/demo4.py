import pandas as pd
from matplotlib import pyplot as py
url='http://samplecsvs.s3.amazonaws.com/Sacramentorealestatetransactions.csv'
df=pd.read_csv(url)
df.plot()
py.show()
