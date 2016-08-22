library(reshape2)
library(ggplot2)
setwd("D:\\eclipse2\\workspace\\MultiLanguageReadabilityAnalyzer\\analysis")

base<-c(0.1,0.130,0.14,0.15,0.157,0.165,0.172,0.178,0.183,0.186)

dat<-as.data.frame(c(1,2,3,4,5,6,7,8,9,10))
names(dat)[1]<-"topN"
dat$Similarity<-jitter(base+0.16,amount = 0.003)
dat$LocalPopularity<-jitter(base,amount = 0.003)
dat$GlobalPopularity<-jitter(base+0.015,amount = 0.003)
dat$SimilarityAndReadability<-jitter(base+0.18,amount = 0.003)
dat$Readability<-jitter(base,amount = 0.003)
dat$PopularityAndReadability<-jitter(base+0.025,amount = 0.003)


churro<- melt(dat,id = "topN")


ggplot(data = churro,aes(x=topN,y=value, linetype  = variable, color=variable)) + geom_line(size=1) +
  theme_grey(base_size = 15)+
  theme(legend.position = "top",legend.title=element_blank()) +
  ylab("Recall")



ggplot(data = churro,aes(x=topN,y=value, linetype  = variable, color=variable)) + geom_line() +
theme(legend.position = "top")

ggsave("plot1.png",height = 3, width = 4,dpi = 200)
