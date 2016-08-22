setwd("D:\\eclipse2\\workspace\\MultiLanguageReadabilityAnalyzer\\analysis")
#install.packages("ggplot2",dependencies = TRUE)
#install.packages("GGally",dependencies = TRUE)
#install.packages("ggExtra",dependencies = TRUE)
library(ggplot2)
library(GGally)
library(ggExtra)
dat <- read.csv("agesOfUsers.tsv",header = TRUE,sep = " ")

mediasUnicas <- as.data.frame(by(dat,dat$userId,function(x) mean(x$age)))

mediasUnicas <- aggregate(dat$age, by=list(userId=dat$userId), mean)

hist(mediasUnicas[mediasUnicas<70])

#unique(dat$userId)

hist(dat$age)
summary(dat$age[dat$age<100])
hist(dat$age[dat$age<70])




ggplot(dat[dat$age<50,], aes(age)) +  geom_histogram(bins =50)

#8819
ggplot(mediasUnicas[mediasUnicas$x<50,], aes(x)) +  geom_histogram(bins =50)+
 theme_grey(base_size=34)+ xlab("age")

summary(mediasUnicas)


