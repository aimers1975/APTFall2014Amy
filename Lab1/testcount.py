def test_remove(list_a, list_b):
  count = 0
  for user in list_a:
    try:
      list_b.remove(user)
      count = count + 1
    except:
      test=0	

  return count

user_list1 = ['bob','john','sad',]
user_list2 = ['bob','john','sad','paul']
b= test_remove(user_list2,user_list1)
print b 