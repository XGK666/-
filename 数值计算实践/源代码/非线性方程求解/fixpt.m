function [x, iter,err,xk_history] = fixpt(F, x0)

switch class(F)
    case 'sym'
        syms x;
        F = matlabFunction(F);
    case 'function_handle'
        syms x;
        F_sym = F(x);
        F = matlabFunction(F_sym);
    otherwise
        error('第一个参数必须为符号函数或函数句柄！');
end
xk = x0;
iter = 0;
xk_history = [];  % 创建一个空向量来存储每次迭代的 xk 值
while true
    xk_1 = F(xk);
    iter = iter + 1;
    err(iter) = xk_1 -xk;
    xk_history(iter) = xk;  % 将每次迭代的 xk 值添加到 xk_history 向量中
    if abs(xk_1 - xk)<0.5
        break
    end
    xk = xk_1;
end

x = xk;