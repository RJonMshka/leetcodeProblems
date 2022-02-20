class Solution:
    def generate(self, numRows):
        list = [[1]]
        for i in range(numRows - 1):
            # appending 0 on both ends of previously appended inner list so that it would be easy to sum
            temp = [0] + list[-1] + [0]
            row = []
            
            for j in range(i + 2):
                row.append(temp[j] + temp[j + 1])
            
            list.append(row)
        
        return list

print(Solution().generate(10))