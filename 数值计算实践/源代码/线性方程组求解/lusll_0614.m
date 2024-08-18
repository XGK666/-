function [L,U,x] = lusll_0614(A, b)
sz = size(A);
L = eye(sz);
U = zeros(sz);

for j = 1:sz
    for i = 1:sz
        if (i <= j)
            U(i,j) = A(i,j) - L(i,1:i-1)*U(1:i-1,j);
        else
            L(i,j) = (A(i,j) - L(i,1:j-1)*U(1:j-1,j)) / U(j,j);
        end
    end
end
y = L \ b;
x = U \ y;
