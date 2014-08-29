def get_common_users(list_a, list_b):
# iterate through site a's users and determine number of users who viewed both a and b
  count = 0
  for user in list_a:
    try:
      list_b.remove(user)
      count = count + 1
    except:
      test=0	
  return count

user_list1 = ['user_2', 'user_3', 'user_1', 'user_9', 'user_8', 'user_7', 'user_4', 'user_9', 'user_4', 'user_3','user_1', 'user_5', 'user_8', 'user_8']
user_list2 = ['user_2', 'user_6', 'user_8', 'user_7', 'user_1', 'user_7', 'user_3', 'user_5', 'user_0', 'user_3','user_2', 'user_3', 'user_9']
print user_list1
print user_list2
affinity = get_common_users(user_list1, user_list2)
print affinity