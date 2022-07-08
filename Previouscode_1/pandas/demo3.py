import pandas as pd
df=pd.DataFrame([{'a': 1, 'b': 2}, {'a': 3, 'b': 4, 'c': 5}])
print(df)
print(df['a'])
df1 = df.reset_index()
print(df1)

df2 = pd.read_csv('./Sacramentorealestatetransactions.csv',index_col=['city'],
                 parse_dates=['sale_date'],dtype = {'zip': 'str'})
print(df2)
# print(df2.loc['MATHER':'COOL'])
# df['type'] == 'Condo'
# print()
byCity = df.groupby('a')
for t in byCity:
    print(t)
# goldRiver = byCity.get_group('b')
# print(goldRiver)