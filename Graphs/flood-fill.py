class Solution:
    def floodFill(self, image, sr, sc, newColor):
        source = image[sr][sc]
        
        if source == newColor:
            return image
        
        self.dfs(image, sr, sc, source, newColor)
        
        return image
        
    def dfs(self, image, sr, sc, source, newColor):
        
        if source != image[sr][sc]:
            return 
        
        rows = len(image)
        cols = len(image[0])
        
        # change image color
        image[sr][sc] = newColor
        
        # top
        if sr-1 >= 0:
            self.dfs(image, sr - 1, sc, source, newColor)
            
        # bottom
        if sr + 1 <= rows - 1:
            self.dfs(image, sr + 1, sc, source, newColor)
        
        # left
        if sc - 1 >= 0:
            self.dfs(image, sr, sc - 1, source, newColor)
        
        # right
        if sc + 1 <= cols - 1:
            self.dfs(image, sr, sc + 1, source, newColor)
    