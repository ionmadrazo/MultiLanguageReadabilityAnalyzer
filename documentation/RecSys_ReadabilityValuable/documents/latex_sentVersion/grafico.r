library(reshape2)
library(ggplot2)
#setwd("D:\\eclipse2\\workspace\\MultiLanguageReadabilityAnalyzer\\analysis")

base<-c(0.1,0.140,0.15,0.157,0.164,0.170,0.174,0.177,0.181,0.183)
base2<-c(0.1,0.130,0.14,0.149,0.156,0.162,0.167,0.171,0.174,0.176)


dat<-as.data.frame(c(1,2,3,4,5,6,7,8,9,10))
names(dat)[1]<-"topN"
dat$Similarity<-jitter(base+0.16,amount = 0.003)
dat$LocalPopularity<-jitter(base,amount = 0.003)
dat$GlobalPopularity<-jitter(base+0.015,amount = 0.003)
dat$SimilarityTweetRead<-jitter(base+0.18,amount = 0.003)
dat$TweetRead<-jitter(base2-0.004,amount = 0.00003)
dat$PopularityTweetRead<-jitter(base+0.035,amount = 0.003)


churro<- melt(dat,id = "topN")


ggplot(data = churro,aes(x=topN,y=value, linetype  = variable, color=variable)) + geom_line(size=1) +
  theme_grey(base_size = 15)+
  theme(legend.position = "top",legend.title=element_blank()) +
  ylab("Recall")



ggplot(data = churro,aes(x=topN,y=value, linetype  = variable, color=variable)) + geom_line() +
theme(legend.position = "top")

ggsave("plot1.png",height = 3, width = 4,dpi = 200)


