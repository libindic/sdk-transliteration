# This script is used to making CMU Dictionary SQLite database for transliteration module from
# file 'cmudict.0.7a_SPHINX_40'
#
# DATABASE NAME : silpa_sdk_transliteration.db
#
# DATABASE TABLES : 1) cmudict_0_7a_sphinx_40
#                   
# DATABASE FIELDS : 1) word (TEXT)
#                   2) phonemes (TEXT)
#

import sqlite3

conn = sqlite3.connect('silpa_sdk_transliteration.db')
print "Opened database successfully";

file_path = "cmudict.0.7a_SPHINX_40"
table_name = "cmudict_0_7a_sphinx_40"
	
conn.execute('CREATE TABLE {} (word TEXT PRIMARY KEY , phonemes TEXT);'.format(table_name))	
	
fdict = open(file_path, "r")
flines = fdict.readlines()

for line in flines:
	line = line.strip()
	word = line.split()[0]
	phonemes = " ".join(line.split()[1:])
	conn.execute('''INSERT OR IGNORE INTO {} (word, phonemes) VALUES (?,?)'''.format(table_name), (word, phonemes,))
		
	
fdict.close()
print "Table ", table_name, " created successfully";	

conn.commit()
conn.close()
print "Database created successfully";
quit()
