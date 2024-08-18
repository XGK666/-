function [L, x] = Cholesky_sll(A, b)
% 程序文件 Cholesky_sll.m
% 本函数是用Cholesky分解法解线性方程组
%           Ax = b
% 输入
% A：  方程组系数矩阵
% b：  方程组右端向量 
% 返回值
% L：  主对角线元素都取正值的下三角阵
% x：  方程组的解

sz = size(A);
L = zeros(sz);

for j = 1:sz
    L(j,j) = sqrt(A(j,j) - sum(L(j,1:j-1).^2));
    L(j+1:sz, j) = (A(j+1:sz,j) - L(j+1:sz,1:j-1)*L(j,1:j-1)') / L(j,j);
end

y = L \ b;
x = L' \ y;
