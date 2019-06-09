export const Identity = x => ({
    emit: () => x,
    chain: f => f(x),
    map: f => Identity(f(x)),
});
