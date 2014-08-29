# No need to process files and manipulate strings - we will
# pass in lists (of equal length) that correspond to 
# sites views. The first list is the site visited, the second is
# the user who visited the site.

# See the test cases for more details.
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
   

def highest_affinity(site_list, user_list, time_list):
  # Returned string pair should be ordered by dictionary order
  # I.e., if the highest affinity pair is "foo" and "bar"
  # return ("bar", "foo"). 
  sitesandusers = dict()
  #go throught the list, and find all the users for one site
  site_list.reverse()
  for site in site_list:
    if (sitesandusers.has_key(site)):
      currentuser = user_list.pop()
      sitesandusers[site].append(currentuser)
    else:
      blanklist = list()
      sitesandusers[site] = blanklist
      currentuser = user_list.pop()
      sitesandusers[site].append(currentuser)
  maxaffinity = 0
  maxpair = tuple()
  for x in range(len(sitesandusers)):
    for y in range(x+1, len(sitesandusers)):
      if(sitesandusers.keys()[x] != sitesandusers.keys()[y]):
        if((len(sitesandusers[sitesandusers.keys()[x]]) >= maxaffinity) or (len(sitesandusers[sitesandusers.keys()[x]]) >= maxaffinity)):
          affinity = get_common_users(sitesandusers[sitesandusers.keys()[x]][:],sitesandusers[sitesandusers.keys()[y]][:])
          if (affinity >= maxaffinity):
            maxaffinity = affinity
            if(sitesandusers.keys()[y] < sitesandusers.keys()[x]):
              maxpair = (sitesandusers.keys()[y],sitesandusers.keys()[x])
            else:
              maxpair = (sitesandusers.keys()[x],sitesandusers.keys()[y])
  return maxpair

