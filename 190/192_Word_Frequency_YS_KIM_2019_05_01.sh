cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'
# 1. split words.txt using ' ' and '\n'
# 2. sort it
# 3. uniq with count
# 4. sort it with desc to make more frequently written words come first
# 5. awk $2 $1
