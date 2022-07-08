import pandas as pd
url = "https://nba.hupu.com/standings"
res = pd.read_html(url)
print(res)