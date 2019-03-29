superhero_kills <- c("superman kills 1030 enemies.",
                     "wonderwoman kills 206 enemies.", 
                     "aquaman kills 32 enemies.",
                     "cyborg kills 17 enemies.", 
                     "batman kills 4 enemies.", 
                     "the flash kills 0 enemies.")

# 替换数字为X
sub("([0-9]+)", "X", superhero_kills)
