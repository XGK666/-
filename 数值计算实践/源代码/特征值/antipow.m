function [lambda, u0, iter, us, ms, err] = antipow(A,p)
%程序文件antipow.m
%本函数是使用反幂法的原点位移法求矩阵A的最小特征值和特征向量
%输入
%A：矩阵
%p：定点
%返回值
%lambda：矩阵特征值
%u0：特征向量
%iter：迭代次数
%us：存储特征向量的迭代序列
%ms：存储特征值的迭代序列
%err：存储误差的迭代序列
    sz = size(A);
    u0 = ones(sz(1), 1); % 初始特征向量
    maxv = max(abs(u0));
    i = 1;
    I = eye(sz); % 单位矩阵

    us = zeros(1000, sz(1)); % 存储特征向量的迭代序列
    ms = zeros(1000, 1); % 存储特征值的迭代序列
    err = zeros(1000, 1); % 存储误差的迭代序列

    u = u0 / maxv;
    while true
        v = (A - p * I) \ u;
        maxv = norm(v, inf);
        u0 = v / maxv;
       
        if norm(u - u0, inf) < 1e-8
            lambda = p + 1 / maxv;
            us(i, :) = u0; 
            ms(i) = lambda;
            err(i) = norm(u - u0, inf);
            break
        end
        
        lambda = p + 1 / maxv;

        us(i, :) = u0;
        ms(i) = lambda;
        err(i) = norm(u - u0, inf);

        u = u0;
        
        i = i + 1;

        if i ==2
            break
        end
    end
    iter = i ;
 % 删除剩余的零行
    us = nonzeros(us);
    us = reshape(us, [], sz(1));  % 将非零元素重新形状为原始的行数
    ms = nonzeros(ms);
    ms = reshape(ms, [], 1);  % 将非零元素重新形状为列向量形式
    err = err(1:iter);
end