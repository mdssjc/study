const List = x => ({
    emit: () => x,
    chain: f => f(x),
    map: f => List(f(x)),
    inspect: () => `List(${x})`,
    concat: a => ListOf(x.concat(a)),
    head: () => x[0],
    tail: () => x[x.length - 1],
});

const ListOf = x => List(x);

const exportList = {
    of: ListOf,
};

export { exportList as List };
